
//written by ALESSANDRA
/* used with buttons that have a circle around them & involved mouse pressed*/

color buttonColor = #718689;//univsersal color variable - can be changed w color modes

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

  void display() {
    if (ellipseOn == "y") { //if user wants stroke or not
      strokeWeight(1.4);
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
  
  void iconsBlue() {//default blue icons for color modes
    image(moonBlue, 831, 700, 40, 40);
    image(sunBlue, 890, 700, 40, 40);
    image(starBlue, 950, 700, 40, 40);
  }

  void iconsPink() {//pink icons for extraColor mode
    image(moonPink, 831, 700, 40, 40);
    image(sunPink, 890, 700, 40, 40);
    image(starPink, 950, 700, 40, 40);
  }


  boolean overButton() {//basically checking if the mouse is on button, used in mousePressed
    if (mouseX > xPos && mouseX < (xPos+size) && mouseY > yPos && mouseY < (yPos+size)) {
      return true;
    }
    return false;
  }
}
