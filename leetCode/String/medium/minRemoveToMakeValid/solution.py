class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        s_list = list(s)
        for i, char in enumerate(s_list):
            if char == '(':
                stack.append(i)
            elif char == ')':
                if stack:
                    stack.pop()
                else: 
                    s_list[i] = ''
        
        for idx in stack:
            s_list[idx] = ''
        return ''.join(s_list)
