class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        i,a,b = 0,abs(dividend),abs(divisor)
        if a==0 or a<b:
            return 0
        while b <= a:
            b = b << 1
            i = i + 1
        else:
            res = (1 << (i-1)) + self.divide(a-(b>>1),abs(divisor))
            if(dividend ^ divisor) < 0:
                res *= -1
            return min(res,(1<<31) -1)

def main():
    import sys
    import io
    def readlines():
        for line in io.TextIOWrapper(sys.stdin.buffer, encoding='utf-8'):
            yield line.strip('\n')

    lines = readlines()
    while True:
        try:
            line = next(lines)
            dividend = int(line);
            line = next(lines)
            divisor = int(line);
            
            ret = Solution().divide(dividend, divisor)

            out = str(ret);
            print(out)
        except StopIteration:
            break

if __name__ == '__main__':
    main()