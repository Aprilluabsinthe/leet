import re
class Solution:
    def validIPAddress(self, IP: str) -> str:
        return self.validIPAddress2(IP)

    def validIPAddress1(self, IP: str) -> str:    
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

    def validate_IPv4(self, IP: str) -> str:
        nums = IP.split('.')
        for x in nums:
            # Validate integer in range (0, 255):
            # 1. length of chunk is between 1 and 3
            if len(x) == 0 or len(x) > 3:
                return "Neither"
            # 2. no extra leading zeros
            # 3. only digits are allowed
            # 4. less than 255
            if x[0] == '0' and len(x) != 1 or not x.isdigit() or int(x) > 255:
                return "Neither"
        return "IPv4"
    
    def validate_IPv6(self, IP: str) -> str:
        nums = IP.split(':')
        hexdigits = '0123456789abcdefABCDEF'
        for x in nums:
            # Validate hexadecimal in range (0, 2**16):
            # 1. at least one and not more than 4 hexdigits in one chunk
            # 2. only hexdigits are allowed: 0-9, a-f, A-F
            if len(x) == 0 or len(x) > 4 or not all(c in hexdigits for c in x):
                return "Neither"
        return "IPv6"
        
    def validIPAddress2(self, IP: str) -> str:
        if IP.count('.') == 3:
            return self.validate_IPv4(IP)
        elif IP.count(':') == 7:
            return self.validate_IPv6(IP)
        else:
            return "Neither"