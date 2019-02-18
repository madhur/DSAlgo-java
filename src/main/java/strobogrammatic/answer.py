def backtrack(n, flips, nums, result, curr):
    if len(curr) == (n + 1) // 2:
        # We cannot use numbers that start with 0, and 6 or 9 cannot be in the center.
        if curr[0] == '0' or (n % 2 != 0 and curr[-1] in ('6', '9')):
           return

        # If the number has an odd number of digits, do not flip and add the center.
        prefix = curr if n % 2 == 0 else curr[:-1]

        # Take each digit down, flip it and reverse it.
        new_res = prefix + list(reversed([flips[num] for num in curr]))

        result.append(''.join(new_res))

    else:
        for num in nums:
            curr.append(num)
            backtrack(n, flips, nums, result, curr)
            curr.pop()

    return result

def strobos(n):
    result = []
    if n == 0:
        return result

    flips = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}
    nums = list(flips.keys())

    result = backtrack(n, flips, nums, result, [])

    return result

if __name__ == '__main__':
    result = strobos(5)
    print(result)
    print(len(result))