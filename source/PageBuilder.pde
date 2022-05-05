
//written by ALESSANDRA
/* to build internal song pages - NOT used for home & about page*/

color pbbgColor = color(0);
color pbtextColor = #718689;//universal color variables

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


  void display() {
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

  void hideIcons() {
    fill(pbbgColor);
    noStroke();
    rect(800, 650, 1000, 500);
    ellSet.displayRight();
    rectSet.displayRight();
  }


  void stars() {
    fill(100);
    noStroke();
    ellipse(random(width), random(height), 5, 5);
  }

  void mouseGlitter() {
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
    rect(mouseX + (x2+0.5), mouseY + x, 2, 2);
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


  void mglitterMoves() {
    if (x < height || x < width) {
      x=x-0.2;
      x1=x1+0.2;
      x2=x2+0.2;
      x3 = x3-0.7;
      xx=xx-0.5;
      xx1=xx1+0.5;
      xx2=xx2+0.7;
    }
  }



  void anim() {//used to test animations - not used in final program
    rect(x, 500, 100, 100);
  }
}
