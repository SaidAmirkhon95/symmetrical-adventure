library ieee;
use ieee.std_logic_1164.all;

entity block_1 is
  port (
    andgate_in_1: in std_logic;
    andgate_in_2: in std_logic;
    andgate_out: out std_logic
  );
end block_1;

architecture rtl of block_1 is
begin
	andgate_out <= andgate_in_1 and andgate_in_2;
end rtl;