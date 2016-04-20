import sys

if __name__ == "__main__":
	k = 1
	for line in sys.stdin:
		nums = line.split()
		nums.pop(0)	
		nums = [int(x) for x in nums]
		mx = max(nums)
		mn = min(nums)
		rng = mx - mn
		print "Case %s: %s %s %s" % (k, mn, mx, rng)
		k = k + 1
