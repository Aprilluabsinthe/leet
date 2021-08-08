class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        import re
        from collections import defaultdict
        paragraph = re.split(r"[!?\',;.\s]",paragraph)
        paragraphList = [x.lower() for x in paragraph if x]
        
        wordCount = defaultdict(int)
        for i in range(len(banned)):
            banned[i] = banned[i].lower()
        
        ans = 0, None
        for word in paragraphList:
            if word not in banned:
                wordCount[word] += 1
                if wordCount[word] > ans[0]:
                    ans = wordCount[word], word
        
        return ans[1]
                
            
            
            
        