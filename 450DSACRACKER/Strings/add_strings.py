def addStrings(self, num1: str, num2: str) -> str:
    numDict = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5,
               '6': 6, '7': 7, '8': 8, '9': 9}

    def str2int(num):
        output = 0
        for i in num:
            output = output * 10 + numDict[i]
        return output

    return str(str2int(num1) + str2int(num2))
