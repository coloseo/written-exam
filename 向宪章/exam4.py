# coding=utf-8


my_list = [{
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

def distinct_list():
    values = {_.get("serial") for _ in my_list}
    new_list = []
    for v in my_list:
        if v.get("serial") in values:
            values.remove(v.get("serial"))
            new_list.append(v)
    print(new_list)

if __name__ == '__main__':
    distinct_list()
