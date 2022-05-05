

//written by ALESSANDRA
/* to add text & change size in one command*/
color addtextColor = #718689;

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

  void display() {
    fill(addtextColor);
    textAlign(LEFT, LEFT);
    textSize(size);
    text(type, x, y);
  }

  void displayRight() { //incase I wanted a right aligned string
    fill(addtextColor);
    textAlign(RIGHT, RIGHT);
    textSize(size);
    text(type, x, y);
  }
  
}
