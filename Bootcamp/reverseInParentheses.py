def reverseInParentheses(inputString):
    n = len(inputString)
    
    stack = []
    
    for i in range(n):
        if inputString[i] == ")":
            temp = []
            while stack[-1] != "(":
                temp.append(stack.pop())
            stack.pop() # pop "("
            
            for c in temp:
                stack.append(c)
            
        else:
            stack.append(inputString[i])
    return "".join(stack)
    
    # return eval('"' + s.replace('(', '"+("').replace(')', '")[::-1]+"') + '"')

