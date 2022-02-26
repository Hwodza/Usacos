"""
//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : February 26th, 2022
//PROBLEM ID                : USACO Sleeping in Class
//SOURCES/HELPERS/HELPED    : Mr.H
"""


t = int(input())
for numruns in range(t):
    total = 0
    n = int(input())
    nums = list(map(int, input().split()))
    #print(nums)
    a,b = 0,1
    while a<len(nums)-1 and b<len(nums):
        #print(nums)
        #print(f'{a} {b}')
        if nums[a]<nums[b]:
            while a>0 and b>1:
                a-=1
                b-=1
                if nums[a] >= nums[b]:
                    break
            total+=1
            nums[a] += nums[b]
            nums.pop(b)
            #print(f'nums: {nums}')
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
            #print(f'nums2: {nums}')
            continue
        a+=1
        b+=1
    print(total)
