package Q16_13_Bisect_Squares;

public class Line {
    public Point start;
    public Point end;
    
    public Line(Point start,Point end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line [end=" + end + ", start=" + start + "]";
    }

    
}
