library ieee;
use ieee.std_logic_1164.all;

entity block_2 is
  port (
    a,b,c,cin : in std_logic;
    cout,sum : out std_logic
  );
end block_2;

architecture rtl of block_2 is
  signal d : std_logic;
begin
	d <= b and c;
	cout <= (a and d) or (a and cin) or (d and cin);
	sum <= a xor d xor cin;
end rtl;