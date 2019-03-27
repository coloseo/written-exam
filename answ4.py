"""
4. 对下面的 json 字符串 serial 相同的进行去重。

```javascript
  [{
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
  }];
```
"""


def foo(data_list):
    _set = set()
    temp_list = []
    for data in data_list:
        val = data.get("serial")
        if val not in _set:
            _set.add(val)
            temp_list.append(data)
    print(temp_list)


if __name__ == '__main__':
    data_list = [{
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
    foo(data_list)
