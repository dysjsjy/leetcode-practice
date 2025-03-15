
# 字典的遍历
from collections import defaultdict

if __name__ == '__main__':
    d = defaultdict()
    # dict的初始化
    for i in range(10):
        d[i] = i + 1

    # 遍历keys
    # for k in d.keys():
    #     print(k)
    #     print(type(k))
    ## 等于
    # for k in d:
    #     print(k)
    #     print(type(k))
    # 遍历values
    for v in d.values():
        print(v)
        print(type(v))