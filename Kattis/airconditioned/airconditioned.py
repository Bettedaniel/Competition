import sys

def max_overlap(mn, mx, ints):
	N = len(ints)
	max_overlapping = []
	for i in range(mn, mx+1):
		i_overlap = []
		for j in range(0, N):
			a = ints[j][0]
			b = ints[j][1]
			if (a <= i and i <= b):
				i_overlap.append(j)
		if (len(i_overlap) > 0):
			max_overlapping.append(i_overlap)
#	print "Overlaps:"
#	print max_overlapping
	m = max([len(x) for x in max_overlapping])
	idx = [i for i, j in enumerate(max_overlapping) if len(j) == m]
#	print "Indices overlapping maximally:"
#	print max_overlapping[idx[0]]
	return max_overlapping, idx

def algorithm(N, ints):
	mn = 201
	mx = 0
	for (a, b) in ints:
		mn = min(mn, a)	
		mx = max(mx, b)
	result = 0
	while (len(ints) > 0):
#		print "Intervals:"
#		print ints
		overlapping, idx = max_overlap(mn, mx, ints)	
		if len(idx) > 0:
			result = result + 1
#			print "Incremented result!"
		for i in reversed(sorted(overlapping[idx[0]])):
			del ints[i]
	return result

def main():
	lines = [line for line in sys.stdin]
	N = int(lines[0].split()[0])
	ints = []
	for i in range(0, N):
		nums = [int(x) for x in lines[i+1].split()]
		ints.append((nums[0], nums[1]))
	result = algorithm(N, ints)
	print result

if __name__ == "__main__":
	main()
