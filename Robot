/*
 * Made By Artem Skulimovskiy
 * 15131 8721
 * AQA Computing project
 */
1 package robot;
  2 /*
  3  * Made By Artem Skulimovskiy
  4  * 15131 8721
  5  * AQA Computing project
  6  */
  7 
  8 import java.io.BufferedReader;
  9 import java.io.File;
 10 import java.io.FileReader;
 11 import java.io.IOException;
 12 
 13 import lejos.hardware.motor.EV3LargeRegulatedMotor;
 14 import lejos.hardware.port.MotorPort;
 15 import lejos.robotics.RegulatedMotor;
 16 import lejos.utility.Delay;
 17 
 18 public class Robot {
 19 
 20   final double TO_DEGREE = (180 / Math.PI);
 21   final int RIGHT_ANGLE = 90;
 22   int count = 1;
 23   int bearing = 0;
 24   int angle = 0;
 25   int currangle = 0;
 26   int xDifference = 0;
 27   int yDifference = 0;
 28   int xOld = 0;
 29   int yOld = 0;
 30   final String FILE_NAME = "text.rtf";
 31   final int SPEED = 300;
 32   final double TURNCON = TurningConstant(SPEED);
 33   final int COORDINATE_LENGTH = 3;
 34   final int XYLENGTH = COORDINATE_LENGTH * 2;
 35   final int DISTANCE_FACTOR = 15;
 36 
 37   /*
 38    * these global variables are needed for the statistical analysis function
 39    * xt and yt are also needed for angle and distance calculation in the robot
 40    * function as well
 41    */
 42   public Robot() {
 43 
 44     int left = LengthOfFile();
 45     int[][] CoordinatesArray = new int[left / (XYLENGTH)][2];
 46     CoordinatesArray = ArrayFromText(CoordinatesArray);
 47     move(CoordinatesArray);
 48 
 49   }
 50 
 51   int StatisticalAnalysis2(int x, int y) {
 52     xDifference = x - xOld;
 53     yDifference = y - yOld;
 54     // xt and yt is the difference in co-ordinates
 55     xOld = x;
 56     yOld = y;
 57     // x2t and y2t is the old x and y co-ordinates
 58     if (count > 1) {
 59       if (xDifference == 0 && yDifference == 0) {
 60         bearing = currangle;
 61         // if the distance is zero the angle stays the same
 62       } else if (yDifference == 0) {
 63         if (xDifference > 0) {
 64           bearing = RIGHT_ANGLE;
 65         } else {
 66           bearing = -RIGHT_ANGLE;
 67         }
 68       } // error when deviding by zero so an if statement was needed
 69       else if (xDifference == 0 && yDifference < 0) {
 70         bearing = RIGHT_ANGLE * 2;
 71       } else {
 72         if (xDifference >= 0) {
 73           if (yDifference >= 0) {
 74             bearing = (int) (Math.atan(Math.abs(xDifference / yDifference)) * TO_DEGREE);
 75 
 76           } else {
 77             bearing = (int) (Math.atan(Math.abs(xDifference / yDifference)) * TO_DEGREE);
 78             bearing = RIGHT_ANGLE - bearing;
 79             bearing += RIGHT_ANGLE;
 80           }
 81         } else {
 82           if (yDifference >= 0) {
 83             bearing = (int) (Math.atan(Math.abs(xDifference / yDifference)) * TO_DEGREE);
 84             bearing = -bearing;
 85           } else {
 86             bearing = (int) (Math.atan(Math.abs(xDifference / yDifference)) * TO_DEGREE);
 87             bearing = RIGHT_ANGLE - bearing;
 88             bearing = -bearing;
 89             bearing -= RIGHT_ANGLE;
 90           }
 91         }
 92       }
 93 
 94       angle = bearing - currangle;
 95       currangle = currangle + angle;
 96     } else {
 97       currangle = 0;
 98       angle = 0;
 99       bearing = 0;
100       count += 2;
101     }
102 
103     return angle;
104   }
105 
106   int Pythagoras(int x, int y) {
107     return (int) (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
108   }
109 
110   double TurningConstant(int speed) {
111     final int CONSTANT = 360000;
112     final int DELAY = CONSTANT / speed;
113     final double TURNCON = (DELAY) / RIGHT_ANGLE;
114     return TURNCON;
115   }
116 
117   int LengthOfFile() {
118     int length = (int) (new File(FILE_NAME).length());
119     return length;
120   }
121 
122   int[][] ArrayFromText(int[][] EmptyArray) {
123 
124     BufferedReader br = null;
125     int countc = 0;
126     int n = 0;
127     long left = LengthOfFile();
128 
129     try {
130 
131       br = new BufferedReader(new FileReader(FILE_NAME));
132       String line;
133 
134       while ((line = br.readLine()) != null) {
135 
136         while (left > XYLENGTH) {
137           EmptyArray[countc][0] = Integer.parseInt(line.substring(n, n + COORDINATE_LENGTH));
138           EmptyArray[countc][1] = Integer.parseInt(line.substring( n + COORDINATE_LENGTH, 
						n + (XYLENGTH)));
139 
140           n += XYLENGTH;
141           countc++;
142           left = left - XYLENGTH;
143 
144         }
145 
146       }
147 
148     } catch (IOException e) {
149       e.printStackTrace();
150     } finally {
151       try {
152         if (br != null) {
153           br.close();
154         }
155       } catch (IOException ex) {
156         ex.printStackTrace();
157       }
158     }
159 
160     return EmptyArray;
161   }
162 
163   void move(int[][] FullArray) {
164     RegulatedMotor mc = new EV3LargeRegulatedMotor(MotorPort.C);
165     RegulatedMotor md = new EV3LargeRegulatedMotor(MotorPort.D);
166     mc.setSpeed(SPEED);
167     md.setSpeed(SPEED);
168     int msdelay;
169     int dist = 0;
170     int countc = 0;
171     int left = LengthOfFile();
172     while (left > 6) {
173 
174       angle = StatisticalAnalysis2(FullArray[countc][0], FullArray[countc][1]);
175       dist = Pythagoras(xDifference, yDifference);
176             // returns and integer distance between previous and new
177       // co-ordinates
178       msdelay = (int) Math.abs(angle * (TURNCON));
179             //if (angle < 0) {
180       //        msdelay = msdelay - (msdelay / ANGLE_ERROR_FACTOR);
181       //}
182 
183       if ((msdelay == 0) && (yDifference >= 0)) {
184 
185       } else if (angle < 0) {
186 
187         // /////////////////////
188         mc.backward();
189         md.forward();
190         Delay.msDelay(msdelay);
191         mc.stop(true);
192         md.stop(true);
193         // //////////////////// ------ left
194 
195       } else {
196 
197         // /////////////////////
198         mc.forward();
199         md.backward();
200         Delay.msDelay(msdelay);
201         mc.stop(true);
202         md.stop(true);
203         // ///////////////////// ------- right
204 
205       }
206 
207       // /////////////////////
208       if (count > 3) {
209         mc.forward();
210         md.forward();
211         Delay.msDelay(dist * DISTANCE_FACTOR);
212         System.out.println(dist);
213         mc.stop(true);
214         md.stop(true);
215       }
216       count++;
217       // ///////////////////// -----> forward
218 
219       left -= 6;
220       countc++;
221     }
222 
223     mc.close();
224     md.close();
225   }
226 
227   public static void main(String[] args) {
228     new Robot();
229         // this will start a method which is 
230     // not static to run the main bit of the programe
231   }
232 
233 }
