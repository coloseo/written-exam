# -*- coding: utf-8 -*-
# ren
# 4：对下面的 json 字符串 serial 相同的进行去重。


def foo():
    values = {_.get("serial") for _ in joon_list}
    new_list = []
    for v in joon_list:
        if v.get("serial") in values:
            values.remove(v.get("serial"))
            new_list.append(v)
    return new_list


joon_list = [{
    "name": "张三",
    "serial": "0001"
  }, {
    "name": "李四",
    "serial": "0002"
  }, {
    "name": "王五",
    "serial": "0003"
  }, {
    "name": "王五2",
    "serial": "0003"
  }, {
    "name": "赵四",
    "serial": "0004"
  }, {
    "name": "小明",
    "serial": "005"
  }, {
    "name": "小张",
    "serial": "006"
  }, {
    "name": "小李",
    "serial": "006"
  }, {
    "name": "小李2",
    "serial": "006"
  }, {
    "name": "赵四2",
    "serial": "0004"
  }]
print(foo())
