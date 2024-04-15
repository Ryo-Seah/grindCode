class Solution:
    def checkValidString(self, s: str) -> bool:
        #two pointer, iterate from left to right and right to left simulatneously
        openCount = 0
        closeCount = 0
        length = len(s)

        for i in range(length):
            if s[i] == "(" or s[i]=="*":
                openCount += 1
            else:
                openCount -=1

            if s[length-i -1] == ")" or s[length-i -1]=="*":
                closeCount +=1
            else:
                closeCount -=1
            
            if openCount<0 or closeCount<0:
                return False
            
        return True
        

            
