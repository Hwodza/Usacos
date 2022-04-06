"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : February 27th, 2022
//PROBLEM ID                : USACO Sleeping in Class
//SOURCES/HELPERS/HELPED    : Mr.H
"""

t = int(input())
for numruns in range(t):
    total = 0
    n = int(input())
    nums2 = list(map(int, input().split()))
    if n == 1:
        print(0)
        continue
    if n == 2:
        if nums2[0] == nums2[1]:
            print(0)
        else:
            print(1)
        continue
    nums = nums2.copy()

    
    
    a,b = 0,1
    while a<len(nums)-1 and b<len(nums):
        if nums[a]<nums[b]:
            while a>0 and b>1:
                a-=1
                b-=1
                if nums[a] >= nums[b]:
                    break
            total+=1
            nums[a] += nums[b]
            nums.pop(b)
            
            continue
        if nums[a]>nums[b]:
            while a<len(nums)-2 and b<len(nums)-1:
                a+=1
                b+=1
                if nums[a] <= nums[b]:
                    break
            total+=1
            nums[a] += nums[b]
            nums.pop(b)
            a -= 1
            b -= 1
            continue
        a+=1
        b+=1
    print(total)