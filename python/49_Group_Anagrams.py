class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs) == 1:
            return [strs]
        res = collections.defaultdict(list)

        for s in strs:
            res[ "".join(sorted(s)) ].append(s)
        return list( res.values())
