class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        if not cpdomains or len(cpdomains) == 0:
            return []
        
        submap = collections.defaultdict(int);
        
        for cpdomain in cpdomains:
            time,domain = cpdomain.split(" ");
            domains = domain.split(".");
            # print(time)
            # print(domain)
            sub = ""
            for i in range(len(domains)-1,-1,-1):
                sub = domains[i] + ("" if i==len(domains)-1 else ".") + sub
                # sub += 
                # print(sub)
                submap[sub] += int(time)
        
        res = []
        for (key,value) in submap.items():
            res.append(str(value) + " " + key)
        
        return res
                
        