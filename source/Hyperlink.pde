
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

  void display() {
    noFill();
    //fill(255,50);
    noStroke();
    rect(xPos, yPos, wid, hi );
    textAlign(CENTER, CENTER);
    fill(buttonColor);
    text(url, xPos, yPos);
  }


  boolean overLink() {//same code as clickableButton class
    if (mouseX > xPos && mouseX < (xPos+wid) && mouseY > yPos && mouseY < (yPos+hi)) {
      return true;
    }
    return false;
  }
}
