import random


def reverse(s):
    if len(s) == 1:
        return s
    else:
        return reverse(s[1:]) + s[0]


def test(n):
    for i in range(n):
        s = ''.join(random.sample('asdjbfnjasenlfj认得你飞机库fnerkfnini分矿务局dskfnk', 8))
        assert reverse(s) == ''.join(list(reversed(s))), '测试失败'


if __name__ == '__main__':
    test(random.randint(1, 100))
    print(reverse(input('请输入字符串\n')))
