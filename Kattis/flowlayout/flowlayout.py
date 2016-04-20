import sys

def algorithm(rectangles, width):
	resultWidth = 0
	resultHeight = 0
	runningWidth = 0
	runningHeight = 0
	for (w, h) in rectangles:
		if runningWidth + w > width:
			resultWidth = max(resultWidth, runningWidth)
			resultHeight = resultHeight + runningHeight
			runningWidth = w
			runningHeight = h
		else:
			runningWidth = runningWidth + w
			runningHeight = max(runningHeight, h)
	resultHeight = resultHeight + runningHeight
	resultWidth = max(resultWidth, runningWidth)

	return (resultWidth, resultHeight)
			

def main():
	width = 0
	rectangles = []
	for line in sys.stdin:
		nums = [int(x) for x in line.split()]
		if len(nums) == 1:
			width = nums[0]
		elif len(nums) == 2 and nums[0] == -1 and nums[1] == -1:
			w, h = algorithm(rectangles, width)	
			print "%s x %s" % (w, h)
			del rectangles[:]
		else:
			rectangles.append((nums[0], nums[1]))
		

if __name__ == "__main__":
	main()
