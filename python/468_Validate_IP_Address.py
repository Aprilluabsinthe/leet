import re
class Solution:
    def validIPAddress(self, IP: str) -> str:    
        chunk_IPv4 = r'(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])'
        pattern_IPv4= re.compile(r'^(' + chunk_IPv4 + r'\.){3}' + chunk_IPv4 + r'$')
        
        # chunk_IPv6 = r'([0-9a-fA-F]{1,4})'
        chunk_IPv6 = r'([\da-fA-F]){1,4}'
        patten_IPv6 = re.compile(r'(' + chunk_IPv6 + r'\:){7}' + chunk_IPv6 + r'$')    
        if '.' in IP:
            return "IPv4" if pattern_IPv4.match(IP) else "Neither" 
        if ':' in IP:
            return "IPv6" if patten_IPv6.match(IP) else "Neither" 
        return "Neither"

    