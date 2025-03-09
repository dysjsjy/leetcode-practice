

class Node:
    __slots__ = 'son', 'end'
    def __init__(self):
        self.son = {}
        self.end = False


# 使用dict
class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        cur = self.root
        for s in word:
            if s not in cur.son:
                cur.son[s] = Node()
            cur = cur.son[s]
        cur.end = True

    def find(self, word: str) -> int:
        cur = self.root
        for s in word:
            if s not in cur.son:
                return 0
            cur = cur.son[s]
        return 2 if cur.end else 1

    def search(self, word: str) -> bool:
        return self.find(word) == 0

    def startsWith(self, prefix: str) -> bool:
        return self.find(prefix) != 0
    
# 使用list
class Trie2:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        cur = self.root
        for s in word:
            s = ord(s) - ord('a')
            if cur.son[s] is None:
                cur.son[s] = Node()
            cur = cur.son[s]
        cur.end = True

    def search(self, word: str) -> bool:
        cur = self.root
        for s in word:
            s = ord(s) - ord('a')
            if cur.son[s] is None:
                return False
            cur = cur.son[s]
        return cur.end

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for s in prefix:
            s = ord(s) - ord('a')
            if cur.son[s] is None:
                return False
            cur = cur.son[s]
        return True