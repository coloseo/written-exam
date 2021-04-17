"""
思路：每次迭代取最后一个字母 字符串长度减一

"""

def reverse(s):
    if len(s)==0:
        return  ""
    else:
        str_len = len(s) # 字符串长度
        str_last_index = s[len(s)-1] # 最后一个字母
        s = s[0:str_len-1] # 字符串截取
        new_str = str_last_index+reverse(s)
        return  new_str
srr_1 = reverse("dfgrt")
print(srr_1)