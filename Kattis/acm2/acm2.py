import sys

def main():
	n = 0
	p = 0
	nums = []
	k = 0
	for line in sys.stdin:
		splitted = line.split()
		if k == 0:
			n = int(splitted[0])
			p = int(splitted[1])
		else:
			nums = [int(x) for x in splitted]
		k = k+1
	time = nums[p]
	result = nums[p]
	del nums[p]
	nums.sort()
	accepted = 1
	if time > 300:
		accepted = 0
		result = 0
	for num in nums:
		if (time + num > 300):
			break
		accepted = accepted + 1
		time = time + num
		result = result + time
	print "%s %s" % (accepted, result)
	

		

if __name__ == "__main__":
	main()
