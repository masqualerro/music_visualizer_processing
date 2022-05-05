import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class finalProject extends PApplet {

//Final Project || DES 111 || SQ21
//Miguel Sedillo & Alessandra Vargas

/*References & Sources of Inspiration:
Levin, Golan, et al. “Messa Di Voce.” Processing: A Programming Handbook for Visual Designers and Artists, pp. 407–408. 
Processing Foundation. “Language Reference (API).” Processing 3+, processing.org/reference/. 
Reas, Casey. Processing: a Programming Handbook for Visual Designers and Artists. The MIT Press, 2014. 
Thirion, Steph. “Eliss.” Processing: A Programming Handbook for Visual Designers and Artists, pp. 261–262. 
Winter, Robert. “Ludwig Van Beethoven: Symphony No. 9.” Processing: A Programming Handbook for Visual Designers and Artists, pp. 253–254. 
*/

//NOTE -- Install minim to use program.
// Sketch --> Import Library --> Add Library --> search for minim

//import minim library 


//Minim variables written by MIGUEL
Minim minim;
AudioPlayer player1;
AudioPlayer player2;
AudioPlayer player3;
AudioPlayer player4;
AudioPlayer player5;

AudioMetaData meta1;
AudioMetaData meta2;
AudioMetaData meta3;
AudioMetaData meta4;
AudioMetaData meta5;
//array for visualizer customization
int[] viz = new int[2];

// written by ALESSANDRA 
//setup calling custom functions & images called from classes
PImage sunBlue, moonBlue, starBlue, sunPink, moonPink, starPink;

public void setup() {
  
  cursor(CROSS);
  PFont inconsolata = createFont("Inconsolata-SemiBold.ttf", 40); //load in custom font
  textFont(inconsolata);
  //calling images - used as icons for color change buttons
  sunBlue = loadImage("sun.png");
  moonBlue = loadImage("moon.png");
  starBlue = loadImage("star.png");
  sunPink = loadImage("sunP.png");
  moonPink = loadImage("moonP.png");
  starPink = loadImage("starP.png");
  pageSetup();
  textSetup();

  //written by MIGUEL minim players / load audio
  minim = new Minim(this);

  player1 = minim.loadFile("green.mp3");
  player2 = minim.loadFile("close_to_me.mp3");
  player3 = minim.loadFile("crush.mp3");
  player4 = minim.loadFile("doomsday.mp3");
  player5 = minim.loadFile("maria.mp3");
  meta1 = player1.getMetaData();
  meta2 = player2.getMetaData();
  meta3 = player3.getMetaData();
  meta4 = player4.getMetaData();
  meta5 = player5.getMetaData();
}


//written by Alessandra
//booleans & color variables set
//if a boolean goes true, it switches to the correct page. also set up some universal color variables to change w color mode buttons
int bgColor = color(0xff000000);
int textColor = color(0xff718689);

boolean keyHome = false;
boolean key1 = false; 
boolean key2 = false;
boolean key3 = false;
boolean key4 = false;
boolean key5= false;

boolean keyW = false;
boolean keyX = false;
boolean keyY = false;
boolean keyZ = false;
boolean keyU = false;
boolean keyV = false;

//booleans for clickable buttons 
boolean darkClick = true; 
boolean lightClick = false;
boolean extraClick = false;
boolean aboutClick = false; 
boolean urlClick = false;


//calling instances for classes
Hyperlink aliURL, migURL; //for clickable "links"
ClickableButton darkMode, lightMode, extraColor, aboutButton; //color mode buttons & about button
PageBuilder greenH, closeH, crushH, doomsH, mariaH; //song pages
AddText green, close, okay, dooms, maria, goBack, ellSet, rectSet, bluSet, redSet, goldSet, randSet, fillSet, nofillSet, customize, aboutPage, alessandra, miguel; //text & text size in one command



//written by ALESSANDRA
public void draw() {
  home();//home page custom function

  if (darkClick == true) { //color mode changes
    darkMode.iconsBlue();//calling blue icons
    bgColor = color(0);
    pbbgColor = color(0);
    pbtextColor = color(0xff718689);
    addtextColor = color(0xff718689);
    buttonColor = color(0xff718689);
  }

  if (lightClick == true) {
    lightMode.iconsBlue();//blue icons
    bgColor = color(230);
    pbbgColor = color(230);
    pbtextColor = color(0xff718689);
    addtextColor = color(0xff718689);
    buttonColor = color(0xff718689);
  }

  if (extraClick == true) {
    extraColor.iconsPink();//pink icons
    bgColor = color(0xffD9D0D0);
    pbbgColor = color(0xffD9D0D0);
    pbtextColor = color(0xff897187);
    addtextColor = color(0xff897187);
    buttonColor = color(0xff897187);
  }

  if (aboutClick == true) {//for about page
    about();
    urlClick = true;
  }

  if (urlClick == true) { //making sure the links only work within the about page
    migURL.display();
    aliURL.display();
  }

  if (key1 == true) { //if corresponding keys are pressed, it brings up all of the corresponding functions from PageBuilder class
    greenH.display();
    greenH.stars();
    greenH.hideIcons();
    greenH.mouseGlitter();
    greenH.mglitterMoves();
    play();
  }

  if (key2 == true) {
    closeH.display();
    closeH.stars();
    closeH.hideIcons();
    closeH.mouseGlitter();
    closeH.mglitterMoves();
    play();
  }

  if (key3 == true) {
    crushH.display();
    crushH.stars();
    crushH.hideIcons();
    crushH.mouseGlitter();
    crushH.mglitterMoves();
    play();
  }

  if (key4 == true) {
    doomsH.display();
    doomsH.stars();
    doomsH.hideIcons();
    doomsH.mouseGlitter();
    doomsH.mglitterMoves();
    play();
  }

  if (key5 == true) {
    mariaH.display();
    mariaH.stars();
    mariaH.hideIcons();
    mariaH.mouseGlitter();
    mariaH.mglitterMoves();
    play();
  }

  if (key == BACKSPACE) {
    home();//calls home page
    aboutClick = false;//if not on home page, about page boolean is false. done to avoid hyperlink class working on other pages
    if (lightClick == true) {
      lightMode.iconsBlue();
    }
    if (darkClick == true) {
      darkMode.iconsBlue();
    }
    if (extraClick == true) {
      extraColor.iconsPink();
    }
  }
}


//written by ALESSANDRA
//setting booleans as true when corresponding button is pressed
//actual visuals are called within draw
public void keyPressed() {
  if (key == '1') {
    key1 = true;
  } 
  if (key == '2') {
    key2 = true;
  }
  if (key == '3') {
    key3 = true;
  }
  if (key == '4') {
    key4 = true;
  }

  if (key == '5') {
    key5 = true;
  }
  if (key == BACKSPACE) {
    keyHome = true;
    aboutClick = false;//setting home & hyperlink booleans to false whenever backspace is hit
    urlClick = false;
  }

  // written by MIGUEL - visualizer customization controls
  if ((key == 'u') || (key == 'U')) {
    viz[0] = 1;
    println("Visualizer set to ellipse");
    println();
  } else if ((key == 'v') || (key == 'V')) {
    viz[0] = 2;
    println("Visualizer set to rectangle");
    println();
  } else if ((key == 'w') || (key == 'W')) {
    viz[1] = 1;
    println("Stroke set to blue");
    println();
  } else if ((key == 'x') || (key == 'X')) {
    viz[1] = 2;
    println("Stroke set to red");
    println();
  } else if ((key == 'y') || (key == 'Y')) {
    viz[1] = 3;
    println("Stroke set to gold");
    println();
  } else if ((key == 'z') || (key == 'Z')) {
    viz[1] = 4;
    println("Stroke randomized");
    println();
  }
  // MIGUEL audio controls -- play/stop etc
  if ((key == 'a') || (key == 'A')) {
    if ((player2.isPlaying()) || (player3.isPlaying()) || (player4.isPlaying()) || (player5.isPlaying())) {
      player2.pause();
      player2.rewind();
      player3.pause();
      player3.rewind();
      player4.pause();
      player4.rewind();
      player5.pause();
      player5.rewind();
      player1.play();
      player1.rewind();
    } else {
      player1.play();
      player1.rewind();
    }
  } else if ((key == 'b') || (key == 'B')) {
    if ((player1.isPlaying()) || (player3.isPlaying()) || (player4.isPlaying()) || (player5.isPlaying())) {
      viz[0] = 2;
      player1.pause();
      player1.rewind();
      player3.pause();
      player3.rewind();
      player4.pause();
      player4.rewind();
      player5.pause();
      player5.rewind();
      player2.play();
      player2.rewind();
    } else {
      player2.play();
      player2.rewind();
    }
  } else if ((key == 'c') || (key == 'C')) {
    if ((player1.isPlaying()) || (player2.isPlaying()) || (player4.isPlaying()) || (player5.isPlaying())) {
      player1.pause();
      player1.rewind();
      player2.pause();
      player2.rewind();
      player4.pause();
      player4.rewind();
      player5.pause();
      player5.rewind();
      player3.play();
      player3.rewind();
    } else {
      player3.play();
      player3.rewind();
    }
  } else if ((key == 'd') || (key == 'D')) {
    if ((player1.isPlaying()) || (player2.isPlaying()) || (player3.isPlaying()) || (player5.isPlaying())) {
      player1.pause();
      player1.rewind();
      player2.pause();
      player2.rewind();
      player3.pause();
      player3.rewind();
      player5.pause();
      player5.rewind();
      player4.play();
      player4.rewind();
    } else {
      player4.play();
      player4.rewind();
    }
  } else if ((key == 'e') || (key == 'E')) {
    if ((player1.isPlaying()) || (player2.isPlaying()) || (player3.isPlaying()) || (player4.isPlaying())) {
      player1.pause();
      player1.rewind();
      player2.pause();
      player2.rewind();
      player3.pause();
      player3.rewind();
      player4.pause();
      player4.rewind();
      player5.play();
      player5.rewind();
    } else {
      player5.play();
      player5.rewind();
    }
  } else if ( (player1.position() == player1.length()) || (player2.position() == player2.length()) || (player3.position() == player3.length()) || (player4.position() == player4.length()) || (player5.position() == player5.length()) ) {
    player1.rewind();
    player2.rewind();
    player3.rewind();
    player4.rewind();
    player5.rewind();
  } else {
    player1.pause();
    player2.pause();
    player3.pause();
    player4.pause();
    player5.pause();
    player1.rewind();
    player2.rewind();
    player3.rewind();
    player4.rewind();
    player5.rewind();
  }
}

//written by ALESSANDRA
public void keyReleased() {
  //keys for pages - set a boolean false as the other gets set as true
  if (key == BACKSPACE) {
    key1 = false;
    key2 = false;
    key3 = false;
    key4=false;
    key5=false;
    aboutClick = false;
    keyHome = true;
  } 
  if (key == '1') {
    keyHome = false;
    key2 = false;
    aboutClick = false;
    key1 = true;
    key3= false;
    key4=false;
    key5=false;
  }

  if (key == '2') {
    keyHome = false;
    key1 = false;
    aboutClick = false;
    key2 = true;
    key3= false;
    key4=false;
    key5=false;
  }

  if (key == '3') {
    keyHome = false;
    key1 = false;
    key2 = false;
    aboutClick = false;
    key3 = true;
    key4=false;
    key5=false;
  }

  if (key == '4') {
    keyHome = false;
    key1 = false;
    aboutClick = false;
    key2 = false;
    key3 =false;
    key4=true;
    key5=false;
  }

  if (key == '5') {
    keyHome = false;
    key1 = false;
    key2 = false;
    aboutClick = false;
    key3 =false;
    key4=false;
    key5=true;
  }


  //keys for visualizer
  if (key == 'a') {
    keyHome = false;
    key1 = true;
    key2 = false;
  }

  if (keyCode == 'w') {
    keyHome = false;
    key1 = false;
    keyX = false;
    key2 = true;
    keyY = false;
    keyZ = false;
    keyW = true;
    keyU = false;
    keyV = false;
  }
  if (keyCode == 'x') {
    keyHome = false;
    key1 = false;
    keyW = false;
    key2 = true;
    keyY = false;
    keyZ = false;
    keyX = true;
    keyU = false;
    keyV = false;
  }
  if (keyCode == 'y') {
    keyHome = false;
    key1 = false;
    key2 = true;
    keyW = false;
    keyX = false;
    keyZ = false;
    keyY = true;
    keyU = false;
    keyV = false;
  }
  if (keyCode == 'z') {
    keyHome = false;
    key1 = false;
    key2 = true;
    keyW = false;
    keyX = false; 
    keyY = false;
    keyZ = true;
    keyU = false;
    keyV = false;
  }
  if (keyCode == 'u') {
    keyHome = false;
    key1 = false;
    key2 = true;
    keyW = false;
    keyX = false; 
    keyY = false;
    keyZ = false;
    keyU = true;
    keyV = false;
  }
  if (keyCode == 'v') {
    keyHome = false;
    key1 = false;
    key2 = true;
    keyW = false;
    keyX = false; 
    keyY = false;
    keyZ = false;
    keyU = false;
    keyV = true;
  }
}

public void mousePressed() {//same thing as above but for the Clickable Button class instances
  if (darkMode.overButton()) {
    lightClick = false;
    extraClick = false;
    darkClick = true;
  }

  if (lightMode.overButton()) {
    lightClick = true;
    extraClick = false;
    darkClick = false;
  }

  if (extraColor.overButton()) {
    lightClick = false;
    extraClick = true;
    darkClick = false;
  }

  if (aboutButton.overButton()) {
    aboutClick = true;
    keyHome = false;
  }

  if (urlClick == true) {
    migURL.display();
    aliURL.display();
    if (aliURL.overLink()) {
      link("https://alessandravargas.com"); //links to my portfolio
    }

    if (migURL.overLink()) {//link to miguel portfolio
      link("http://des117.space/wi2021-mead/masedillo/portfolio_site/index.html");
    }
  }
}

// written by MIGUEL visualizer functions (ellipse and rectangle options)
public void ellipse_visualizer(int x, int y) {
  ellipse(x, y, player1.left.level()*width*2, player1.right.level()*width*2);
  ellipse(x, y, player1.right.level()*width*3, player1.left.level()*width*3);
  ellipse(x, y, player1.left.level()*width, player1.right.level()*width);
  ellipse(x, y, player1.right.level()*width, player1.left.level()*width);
  ellipse(x, y, 0, player1.right.level()*width*2);

  ellipse(x, y, player2.left.level()*width*2, player2.right.level()*width*2);
  ellipse(x, y, player2.right.level()*width*3, player2.left.level()*width*3);
  ellipse(x, y, player2.left.level()*width, player2.right.level()*width);
  ellipse(x, y, player2.right.level()*width, player2.left.level()*width);
  ellipse(x, y, 0, player2.right.level()*width*2);

  ellipse(x, y, player3.left.level()*width*2, player3.right.level()*width*2);
  ellipse(x, y, player3.right.level()*width*3, player3.left.level()*width*3);
  ellipse(x, y, player3.left.level()*width, player3.right.level()*width);
  ellipse(x, y, player3.right.level()*width, player3.left.level()*width);
  ellipse(x, y, 0, player3.right.level()*width*2);

  ellipse(x, y, player4.left.level()*width*2, player4.right.level()*width*2);
  ellipse(x, y, player4.right.level()*width*3, player4.left.level()*width*3);
  ellipse(x, y, player4.left.level()*width, player4.right.level()*width);
  ellipse(x, y, player4.right.level()*width, player4.left.level()*width);
  ellipse(x, y, 0, player4.right.level()*width*2);

  ellipse(x, y, player5.left.level()*width*2, player5.right.level()*width*2);
  ellipse(x, y, player5.right.level()*width*3, player5.left.level()*width*3);
  ellipse(x, y, player5.left.level()*width, player5.right.level()*width);
  ellipse(x, y, player5.right.level()*width, player5.left.level()*width);
  ellipse(x, y, 0, player5.right.level()*width*2);
}

public void rect_visualizer(int x, int y) {
  rectMode(CENTER);
  rect(x, y, player1.left.level()*width*2, player1.right.level()*width*2);
  rect(x, y, player1.right.level()*width*3, player1.left.level()*width*3);
  rect(x, y, player1.left.level()*width, player1.right.level()*width);
  rect(x, y, player1.right.level()*width, player1.left.level()*width);
  rect(x, y, player1.right.level()*width*5, player1.left.level()*width);
  rect(x, y, player1.right.level()*width, player1.right.level()*width*5);
  rect(x, y, 0, player1.right.level()*width*2);

  rect(x, y, player2.left.level()*width*2, player2.right.level()*width*2);
  rect(x, y, player2.right.level()*width*3, player2.left.level()*width*3);
  rect(x, y, player2.left.level()*width, player2.right.level()*width);
  rect(x, y, player2.right.level()*width, player2.left.level()*width);
  rect(x, y, player2.right.level()*width*5, player2.left.level()*width);
  rect(x, y, player2.right.level()*width, player2.right.level()*width*5);
  rect(x, y, 0, player2.right.level()*width*2);

  rect(x, y, player3.left.level()*width*2, player3.right.level()*width*2);
  rect(x, y, player3.right.level()*width*3, player3.left.level()*width*3);
  rect(x, y, player3.left.level()*width, player3.right.level()*width);
  rect(x, y, player3.right.level()*width, player3.left.level()*width);
  rect(x, y, player3.right.level()*width*5, player3.left.level()*width);
  rect(x, y, player3.right.level()*width, player3.right.level()*width*5);
  rect(x, y, 0, player3.right.level()*width*2);

  rect(x, y, player4.left.level()*width*2, player4.right.level()*width*2);
  rect(x, y, player4.right.level()*width*3, player4.left.level()*width*3);
  rect(x, y, player4.left.level()*width, player4.right.level()*width);
  rect(x, y, player4.right.level()*width, player4.left.level()*width);
  rect(x, y, player4.right.level()*width*5, player4.left.level()*width);
  rect(x, y, player4.right.level()*width, player4.right.level()*width*5);
  rect(x, y, 0, player4.right.level()*width*2);

  rect(x, y, player5.left.level()*width*2, player5.right.level()*width*2);
  rect(x, y, player5.right.level()*width*3, player5.left.level()*width*3);
  rect(x, y, player5.left.level()*width, player5.right.level()*width);
  rect(x, y, player5.right.level()*width, player5.left.level()*width);
  rect(x, y, player5.right.level()*width*5, player5.left.level()*width);
  rect(x, y, player5.right.level()*width, player5.right.level()*width*5);
  rect(x, y, 0, player5.right.level()*width*2);
}

//written by ALESSANDRA
public void pageSetup() { //creating all of the variables from page builder class - called in setup thru this custom function (makes setup less crowded)
  greenH = new PageBuilder("Green - Robohands", "Use keys below to custom visualizer, then press 'a' to play.", "Press BACKSPACE to return home.");
  closeH = new PageBuilder("Close to Me - The Cure", "Use keys below to custom visualizer, then press 'b' to play.", "Press BACKSPACE to return home.");
  crushH = new PageBuilder("Instant Crush - Daft Punk (ft. Julian Casablancas)", "Use keys below to custom visualizer, then press 'c' to play.", "Press BACKSPACE to return home.");
  doomsH = new PageBuilder("Doomsday - MF DOOM", "Use keys below to custom visualizer, then press 'd' to play.", "Press BACKSPACE to return home.");
  mariaH = new PageBuilder("Maria Niguem - Joao Gilberto", "Use keys below to custom visualizer, then press 'e' to play.", "Press BACKSPACE to return home.");
}

public void textSetup() {//calling AddText variables 
  green = new AddText("press '1' for Green by Robohands", 40, 120, 20);
  close = new AddText("press '2' for Close to Me by The Cure", 40, 160, 20);
  okay = new AddText("press '3' for Instant Crush by Daft Punk (ft. Julian Casablancas)", 40, 200, 20);
  dooms = new AddText("press '4' for Doomsday by MF DOOM", 40, 240, 20);
  maria = new AddText("press '5' for Maria Niguem by Joao Gilberto", 40, 280, 20);
  goBack = new AddText("press BACKSPACE to go back home", 40, 360, 20);

  //ellSet, rectSet, bluSet, redSet, goldSet, randSet, fillSet, nofillSet; - These are visualizer option instructions
  ellSet = new AddText("press 'u' for ellipse visualizer", 985, 710, 15);// xyz
  rectSet = new AddText("press 'v' for rectangle visualizer", 985, 730, 15);
  bluSet = new AddText("press 'w' for blue stroke", 40, 670, 15);
  redSet = new AddText("press 'x' for red stroke", 40, 690, 15);
  goldSet = new AddText("press 'y' for gold stroke", 40, 710, 15);
  randSet = new AddText("press 'z' to randomize stroke", 40, 730, 15);
  customize = new AddText("Customize Visualizer", 40, 630, 15);

  //darkMode, lightMode, extraColor; - variables from Clickable button class (color modes & about)
  //ClickableButton(float xPost, float yPost, float sizeT, String textOnt, String ellipseOnt)
  darkMode = new ClickableButton(850, 720, 50, "    ", "y");
  lightMode = new ClickableButton(910, 720, 50, "    ", "y");
  extraColor = new ClickableButton(970, 720, 50, "    ", "y");
  aboutButton = new ClickableButton(48, 720, 50, "?", "y");

  //hyperlink & about setup - using AddText & Hyperlink classes.
  aliURL = new Hyperlink (35, 600, 210, 25, " ");
  migURL = new Hyperlink (270, 600, 170, 25, " ");
  aboutPage = new AddText("This project was created and developed for DES 111 during Spring Quarter 2021 by Miguel Sedillo and\nAlessandra Vargas. We were motivated to recreate a modern version of the early 2000s/late 90s music visualizer.\nWe wanted to explore the interaction between sound and design, as well as generate a visual display\nbased upon user interaction and input  - something that cannot be created simply through the usage of the\nAdobe or Google suite. We both have a great passion for music, and this project was the perfect way to\ncollaborate on something of shared interest. To meet Objective B (specifically point #1),  we took the\nprinciples of design theory (especially pattern, rhythm, variety, movement, and balance) into account, allowing\nus to bring our concept to fruition. For our project, we created an audio player which allows the user to\nbrowse through a handful of songs, then generates an abstract display that fluctuates and changes in relation to\nan audio track chosen by the user. The display is customizable, letting the user select its stroke color, as\nwell as the shapes generated during the display. Casey Reas’s Processing: A Programming Handbook for\nVisual Designers and Artists, and more specifically, the artists and developers mentioned within it, have been\na huge inspiration for our final project. We were especially inspired by works mentioned in Reas’s text,\nsuch as Robert Winter’s Ludwig van Beethoven: Symphony No. 9, Tmema’s Messa di Voce, and Steph Thirion’s Eliss.\nThese works are masterful examples of visual interactivity, either linked to music or physical user\ninteraction, and served as good references for our final project. Processing.org’s reference and examples\npages were also of great help as we worked our way through the completion of our project.", 35, 150, 17);
  alessandra = new AddText("Alessandra's Website", 40, 620, 20);
  miguel = new AddText("Miguel's Website", 275, 620, 20);
}

//written by ALESSANDRA
public void home() {//home page custom function - didn't use Pagebuilder bc dif. format
  background(bgColor);
  goBack.display();
  green.display();
  close.display();
  okay.display();
  dooms.display();
  maria.display();
  darkMode.display();
  lightMode.display();
  extraColor.display();
  aboutButton.display();
}

public void about() {//about page custom function called in draw
  background(bgColor);
  fill(pbtextColor);
  textSize(35);
  textAlign(LEFT, LEFT);
  text("About", 40, 80);
  textSize(15);
  text("Press BACKSPACE to go back home\n", 40, 110);
  aboutPage.display();
  alessandra.display();
  miguel.display();
}

//written by MIGUEL more visualizer functions !!

//this function dislays length/duration of song as it plays at top of window
public void play() {
  float posx1 = map(player1.position(), 0, player1.length(), 0, width);
  rect(0, 0, posx1, 10);
  float posx2 = map(player2.position(), 0, player2.length(), 0, width);
  rect(0, 0, posx2, 10);
  float posx3 = map(player3.position(), 0, player3.length(), 0, width);
  rect(0, 0, posx3, 10);
  float posx4 = map(player4.position(), 0, player4.length(), 0, width);
  rect(0, 0, posx4, 10);
  float posx5 = map(player5.position(), 0, player5.length(), 0, width);
  rect(0, 0, posx5, 10);

  noStroke();
  fill(bgColor);
  rect(0, 0, 0.8f, 12);
  noFill();

  //MIGUEL ELLIPSE VISUALIZER 
  //these change stroke of visualizer based on user input and array positions
  if ( (viz[0] == 1) && (viz[1] == 1) ) {
    stroke(0xff718689);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 1) && (viz[1] == 2) ) {
    stroke(0xffBF4F45);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 1) && (viz[1] == 3) ) {
    stroke(0xffF2B705);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 1) && (viz[1] == 4) ) {
    stroke(random(255), random(255), random(255));
    ellipse_visualizer(512, 384);
  }

  //MIGUEL RECTANGLE VISUALIZER
  //same as above but with rectangle
  if ( (viz[0] == 2) && (viz[1] == 1) ) {
    stroke(0xff718689);
    rect_visualizer(512, 384);
  } else if ( (viz[0] == 2) && (viz[1] == 2) ) {
    stroke(0xffBF4F45);
    rect_visualizer(512, 384);
  } else if ( (viz[0] == 2) && (viz[1] == 3) ) {
    stroke(0xffF2B705);
    rect_visualizer(512, 384);
  } else if ( (viz[0] == 2) && (viz[1] == 4) ) {
    stroke(random(255), random(255), random(255));
    rect_visualizer(512, 384);
  } 

  //DEFAULTS IF USER DID NOT SELECT CUSTOMIZATION OPTIONS (MIGUEL)
  else if ( (viz[0] == 1) && (viz[1] == 0) ) {
    stroke(0xff718689);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 2) && (viz[1] == 0) ) {
    stroke(0xff718689);
    rect_visualizer(512, 384);
  } else if ( (viz[0] == 0) && (viz[1] == 1) ) {
    stroke(0xff718689);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 0) && (viz[1] == 2) ) {
    stroke(0xffBF4F45);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 0) && (viz[1] == 3) ) {
    stroke(0xffF2B705);
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 0) && (viz[1] == 4) ) {
    stroke(random(255), random(255), random(255));
    ellipse_visualizer(512, 384);
  } else if ( (viz[0] == 0) && (viz[1] == 0) ) {
    stroke(0xff718689);
    ellipse_visualizer(512, 384);
  }
}


//written by ALESSANDRA
/* to add text & change size in one command*/
int addtextColor = 0xff718689;

class AddText {
  String type;
  float x;
  float y;
  float size;

  AddText(String typeT, float xT, float yT, float sizeT) {
    type = typeT;
    x = xT;
    y = yT;
    size = sizeT;
  }

  public void display() {
    fill(addtextColor);
    textAlign(LEFT, LEFT);
    textSize(size);
    text(type, x, y);
  }

  public void displayRight() { //incase I wanted a right aligned string
    fill(addtextColor);
    textAlign(RIGHT, RIGHT);
    textSize(size);
    text(type, x, y);
  }
  
}

//written by ALESSANDRA
/* used with buttons that have a circle around them & involved mouse pressed*/

int buttonColor = 0xff718689;//univsersal color variable - can be changed w color modes

class ClickableButton {
  float xPos;
  float yPos;
  float size; // both height & width
  String textOn;
  String ellipseOn;

  ClickableButton(float xPost, float yPost, float sizeT, String textOnt, String ellipseOnt) {
    xPos = xPost;
    yPos = yPost;
    size = sizeT;//set one variable for height and width bc i want a perfect circle
    textOn = textOnt;//text for button - might be just blank to allow clicking space
    ellipseOn = ellipseOnt;//input string that decides if there is a stroke on button or not
  }

  public void display() {
    if (ellipseOn == "y") { //if user wants stroke or not
      strokeWeight(1.4f);
      // fill(0);
      stroke(buttonColor);
    }
    if (ellipseOn == "n") { //no stroke
      stroke(0);
    }

    noFill();
    //fill(0);
    ellipse(xPos, yPos, size, size);
    textAlign(CENTER, CENTER);
    fill(buttonColor);
    text(textOn, xPos, yPos );
  }
  
  public void iconsBlue() {//default blue icons for color modes
    image(moonBlue, 831, 700, 40, 40);
    image(sunBlue, 890, 700, 40, 40);
    image(starBlue, 950, 700, 40, 40);
  }

  public void iconsPink() {//pink icons for extraColor mode
    image(moonPink, 831, 700, 40, 40);
    image(sunPink, 890, 700, 40, 40);
    image(starPink, 950, 700, 40, 40);
  }


  public boolean overButton() {//basically checking if the mouse is on button, used in mousePressed
    if (mouseX > xPos && mouseX < (xPos+size) && mouseY > yPos && mouseY < (yPos+size)) {
      return true;
    }
    return false;
  }
}

//written by ALESSANDRA
/* used to create hyperlinks!  
aka an invisible rectangular button
that can b used w link("string");*/

class Hyperlink {
  float xPos;
  float yPos;
  float wid; //height & width
  float hi;
  String url;//can be left blank if this button will be overlaid on strings 

  Hyperlink(float xPost, float yPost, float widt, float hit, String urlt) {
    xPos = xPost;
    yPos = yPost;
    hi = hit;
    wid = widt;
    url = urlt;
  }

  public void display() {
    noFill();
    //fill(255,50);
    noStroke();
    rect(xPos, yPos, wid, hi );
    textAlign(CENTER, CENTER);
    fill(buttonColor);
    text(url, xPos, yPos);
  }


  public boolean overLink() {//same code as clickableButton class
    if (mouseX > xPos && mouseX < (xPos+wid) && mouseY > yPos && mouseY < (yPos+hi)) {
      return true;
    }
    return false;
  }
}

//written by ALESSANDRA
/* to build internal song pages - NOT used for home & about page*/

int pbbgColor = color(0);
int pbtextColor = 0xff718689;//universal color variables

//glitter mouse variables
float x = 1;
float x1 = 1;
float x2 = 1;
float x3 = 1;
float xx = 1;
float xx1 = 1;
float xx2 = 1;

class PageBuilder {
  String artistSong;
  String letterMap;
  String backInstructions;

  PageBuilder(String artistSongt, String letterMapt, String backInstructionst) {
    artistSong = artistSongt;
    letterMap = letterMapt;
    backInstructions = backInstructionst;
  }


  public void display() {
    fill(pbtextColor);
    background(pbbgColor);
    textSize(35);
    textAlign(LEFT, LEFT);
    text(artistSong, 40, 80);
    textSize(15);
    text(letterMap, 40, 105);
    text(backInstructions, 40, 125);
    customize.display();

    bluSet.display();
    redSet.display();
    goldSet.display();
    randSet.display();

  }

  public void hideIcons() {
    fill(pbbgColor);
    noStroke();
    rect(800, 650, 1000, 500);
    ellSet.displayRight();
    rectSet.displayRight();
  }


  public void stars() {
    fill(100);
    noStroke();
    ellipse(random(width), random(height), 5, 5);
  }

  public void mouseGlitter() {
    fill(pbtextColor, 100);
    rect(mouseX + x1, mouseY + x, 2, 2);
    rect(mouseX + x, mouseY + x, 2, 2);
    rect(mouseX, mouseY + xx, 2, 2);
    ellipse(mouseX + xx, mouseY + xx, 2, 2);
    ellipse(mouseX + x1, mouseY + xx, 2, 2);
    rect(mouseX - xx1, mouseY + x, 2, 2);
    rect(mouseX - xx1, mouseY - x, 2, 2);
    ellipse(mouseX + x1, mouseY + xx2, 2, 2);
    ellipse(mouseX - x1, mouseY + xx2, 2, 2);
    rect(mouseX + xx1, mouseY + x, 2, 2);
    rect(mouseX + (x2+0.5f), mouseY + x, 2, 2);
    rect(mouseX + x2, mouseY + x2, 2, 2);
    rect(mouseX + xx1, mouseY + x1, 2, 2);
    rect(mouseX, mouseY + x2, 2, 2);
    rect(mouseX, mouseY + x3, 2, 2);
    rect(mouseX + xx1, mouseY + x1, 2, 2);
    ellipse(mouseX + x, mouseY + xx2, 2, 2);
    ellipse(mouseX + x1, mouseY + x1, 2, 2);
    rect(mouseX +x3, mouseY + x3, 2, 2);
    rect(mouseX -x3, mouseY - x3, 2, 2);
  }


  public void mglitterMoves() {
    if (x < height || x < width) {
      x=x-0.2f;
      x1=x1+0.2f;
      x2=x2+0.2f;
      x3 = x3-0.7f;
      xx=xx-0.5f;
      xx1=xx1+0.5f;
      xx2=xx2+0.7f;
    }
  }



  public void anim() {//used to test animations - not used in final program
    rect(x, 500, 100, 100);
  }
}
  public void settings() {  size(1024, 768); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "finalProject" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
