import json

def reverse(s):
	'''
	逆序字符串
	'''
	if not s or len(s)==1:
		return s

	return reverse(s[1:])+s[0]	


class MergeSort:
	'''
	归并排序

	'''
	def sort(self,arr):
		if len(arr) <= 1:
			return arr

		mid = len(arr)>>1
		left = self.sort(arr[:mid])
		right = self.sort(arr[mid:])
		return self.merge(left,right)
		

	def merge(self,list1,list2):
		temp = []
		left=right=0

		while left<len(list1) and right<len(list2):
			if list1[left] <= list2[right]:
				temp.append(list1[left])
				left+=1
			else:
				temp.append(list2[right])
				right+=1

		temp.extend(list1[left:]) if left<len(list1) else temp.extend(list2[right:])			

		return temp


def uniqueJson(jsondata):
	'''
	json去重
	'''

	data = json.loads(jsondata)
	temp = data[:]
	serial = []

	for item in temp:
		if item['serial'] in serial:
			data.remove(item)
		serial.append(item['serial'])

	return data
	pass


def json2Tree(jsondata):
	'''
	json变组织树
	'''
	cityData = json.loads(jsondata)
	temp = {}
	result = []

	for city in cityData:
		temp[city['code']] = city
	
	for city in temp.values():
		pid = city['parent']
		if pid:
			nodes = temp[pid].get('nodes',[])
			nodes.append(city)
			temp[pid]['nodes'] = nodes
		else:
			result.append(city)

	return result

if __name__ == "__main__":
	reverse('abs')


	merge = MergeSort()
	a = [3,1,4,1,5,9,2,6]
	b = merge.sort(a)
	

	c =''' 
	[{
	"name":"张三",
	"serial": "0001"
	},
	{
	"name": "李四",
	"serial": "0002"
	}, 
	{
	"name": "王五",
	"serial": "0003"
	}, 
	{"name": "王五2",
	"serial": "0003"
	}]
	'''

	
	jsondata = uniqueJson(c)
	

	cityData = '''
	[{
      "id": "1",
      "name": "中国",
      "code": "110",
      "parent": ""
    },
    {
      "id": "2",
      "name": "北京市",
      "code": "110000",
      "parent": "110"
    },
    {
      "id": "3",
      "name": "河北省",
      "code": "130000",
      "parent": "110"
    },
    {
      "id": "4",
      "name": "四川省",
      "code": "510000",
      "parent": "110"
    },
    {
      "id": "5",
      "name": "石家庄市",
      "code": "130001",
      "parent": "130000"
    },
    {
      "id": "6",
      "name": "唐山市",
      "code": "130002",
      "parent": "130000"
    },
    {
      "id": "7",
      "name": "邢台市",
      "code": "130003",
      "parent": "130000"
    },
    {
      "id": "8",
      "name": "成都市",
      "code": "510001",
      "parent": "510000"
    },
    {
      "id": "9",
      "name": "简阳市",
      "code": "510002",
      "parent": "510000"
    },
    {
      "id": "10",
      "name": "武侯区",
      "code": "51000101",
      "parent": "510001"
    },
    {
      "id": "11",
      "name": "金牛区",
      "code": "51000102",
      "parent": "510001"
    }
  ]
  '''

	treeData = json2Tree(cityData)