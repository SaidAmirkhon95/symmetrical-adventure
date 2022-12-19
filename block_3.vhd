library ieee;
use ieee.std_logic_1164.all;

entity block_3 is
  port (
    a,b,c: in std_logic;
    cout,sum: out std_logic
  );
end block_3;

architecture rtl of block_3 is
	signal d : std_logic;
begin
	d <= b and c;
	sum <= a xor d;
	cout <= a and d;
end rtl;