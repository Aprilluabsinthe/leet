def change(amount, coins):
    dp = [0] * (amount+1)
    
    dp[0] = 1
    
    # for coin in coins:
    #     for i in range(coin,(amount+1)):
    #         # dp[i] += dp[i-coin]
    #         dp[i] += dp[i-coin]

    for i in range(1,(amount+1)):
        for coin in coins:
            if i >= coin :
                dp[i] += dp[i-coin]
    
    return dp[-1]

coins = [1,2,3,4]
print(change(3,coins))