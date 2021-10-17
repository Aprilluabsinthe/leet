public class Q8_13_boxstack {
    public int creatStack(ArrayList<Box> boxes){
        Collections.sort(boxes,new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStack(boxes, null,0,stackMap);
    }

    public createStack(ArrayList<Box> boxes, Box Bottom, int offset, int[] stackMap){
        if(offset >= boxes.size(0)) return 0;

        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if(bottom == null || newBottom.canBeAbove(bottom)){
            if(stackMap[offset] == 0){
                stackMap[offset] = createStack(boxes,newBottom,offset+1,stackMap);
                stackMap[offset] += newBottom.height;
            }
            heightWithBottom = stackMap[offset];
        }

        int heightWithoutBottom = createStack(boxes,bottom,offset+1,stackMap);
        return Math.max(heightWithoutBottom,heightWithoutBottom);

    }
}
