class Solution:
    def checkValidString(self, s: str) -> bool:
        list_s = list(s)
        stack = []
        star_stack = []
        for i, char in enumerate(list_s):
            if char == '(':
                stack.append(i)
            elif char == '*':
                star_stack.append(i)
            else:
                if stack: 
                    stack.pop()
                elif star_stack:a
                    star_stack.pop()
                else:
                    return False
                
        #check that open brackets come before stars
        while stack and star_stack:
            if stack.pop() > star_stack.pop():
                return False

        return not stack

        
        

            
