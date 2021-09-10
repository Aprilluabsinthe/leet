class Solution:
    def videoStitching(self, clips: List[List[int]], time: int) -> int:
        clips = sorted(clips, key = lambda x:(x[0],x[1]))
        
        farest = [0] * time

        for clip in clips:
            for j in range( clip[0] , min( time, clip[1]+1) ):
                farest[j] = max(farest[j] , min( time, clip[1] ))

        end = last = count = 0

        for i in range(time):
            last = max(last, farest[i])
            if last == i:
                return -1
            if i == end:
                end = last
                count += 1
        
        return count
