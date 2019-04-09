package insanevehicles.element;

public class Element {
    private char sprite;

    public Element(char sprite) {
        this.sprite=sprite;
    }

    public char getSprite() {
        return sprite;
    }

    private void setSprite(char sprite) {
        this.sprite = sprite;
    }
}
