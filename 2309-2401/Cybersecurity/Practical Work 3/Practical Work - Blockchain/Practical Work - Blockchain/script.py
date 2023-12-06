import hashlib

# Block header data provided in little-endian hexadecimal notation
header_block1 = "0100000081cd02ab7e569e8bcd9317e2fe99f2de44d49ab2b8851ba4a308000000000000e320b6c2fffc8d750423db8b1eb942ae710e951ed797f7affc8892b0f1fc122bc7f5d74df2b9441a42a14695"

# Convert little-endian hex to big-endian hex
block_header_bytes = bytes.fromhex(header_block1)
block_header_big_endian = block_header_bytes[::-1].hex()

# Calculate the hash of the block header using double SHA256
block_hash = hashlib.sha256(hashlib.sha256(block_header_bytes).digest()).digest()[::-1].hex()

print("Block Hash:", block_hash)

