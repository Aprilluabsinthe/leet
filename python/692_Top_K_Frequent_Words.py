class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        dictionary = collections.defaultdict(int)
        for word in words:
            dictionary[word] += 1
        
        arr = []
        for key,value in dictionary.items():
            arr.append([key,value])
        
        arr = sorted(arr,key=lambda x : (-x[1],x[0]),reverse=False)
        return [arr[i][0] for i in range(k)]