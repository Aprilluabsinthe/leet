def hanoi(number,src,dst,helper):
    if number <= 0:
        return
    
    hanoi(number-1,src,helper,dst)
    print(f"move disk {number-1} from {src} to {helper}")
    hanoi(number-1,helper,dst,src)
    print(f"move disk {number-1} from {helper} to {dst}")

hanoi(5,"A","B","C")