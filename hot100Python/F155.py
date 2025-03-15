
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        cur = self.stack.pop()
        if cur == self.min_stack[-1]:
            self.min_stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        return None

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
        return None
    
'''
就是用两个列表，一个列表正常放元素，另一个列表一直存储列表中最小的数，
怎么保证min_stack中始终最后的一个是最小的呢，
每往stack中放一个元素都和min_stack中的最后一个元素比较一下，如果更小则在放进stack的同时也放进min_stack，
pop则是弹出stack中最后一个元素，这时要确认，弹出的元素是不是最小的，如果是就把min_stack中的也弹出，
top只是查看stack中最后一个元素，直接返回stack中的最后一个元素就可以了，没有就返回None，
getMin直接返回min_stack的最后一个元素就可以了，如果没有就返回None，
时间复杂度(1)，
空间复杂度(q)，q就是执行push的次数，
'''

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()