library ieee;
use ieee.std_logic_1164.all;

--Three blocks are provided in this template(block_1, block_2 and block_3), 
--you can complete the design of this multiplier by connecting these blocks,
--or you can also design your own block based on your implementation.

entity parallel_mult is
  port (
    x,y : in std_logic_vector(3 downto 0);
	z : out std_logic_vector(7 downto 0)	
  );
end parallel_mult;

architecture rtl of parallel_mult is
	signal zz : std_logic_vector(7 downto 0);
	signal xy_out1 : std_logic_vector(2 downto 0);
	signal carry_1 : std_logic_vector (3 downto 0);
	signal xy_out2 : std_logic_vector (2 downto 0);
	signal carry_2 : std_logic_vector (3 downto 0);
	signal xy_out3 : std_logic_vector (2 downto 0);
	signal carry_3 : std_logic_vector (2 downto 0);
	
	component block_1
	port (
    andgate_in_1: in std_logic;
    andgate_in_2: in std_logic;
    andgate_out: out std_logic
	);
	end component;
	
    component block_2
	port (
    a,b,c,cin : in std_logic;
    cout,sum : out std_logic
	);
	end component;
    
	component block_3 
	port (
    a,b,c: in std_logic;
    cout,sum: out std_logic
	);
	end component;
	 
begin
	row_0_0 : block_1 port map (andgate_in_1 => x(0), andgate_in_2 => y(0), andgate_out => zz(0));
    row_0_1 : block_1 port map (andgate_in_1 => x(1), andgate_in_2 => y(0), andgate_out => xy_out1(0));
    row_0_2 : block_1 port map (andgate_in_1 => x(2), andgate_in_2 => y(0), andgate_out => xy_out1(1));
    row_0_3 : block_1 port map (andgate_in_1 => x(3), andgate_in_2 => y(0), andgate_out => xy_out1(2));
	
	row_1_0 : block_3 port map (b => x(0), c => y(1), a => xy_out1(0), cout => carry_1(0), sum => zz(1));
	row_1_1 : block_2 port map (b => x(1), c => y(1), a => xy_out1(1), cin => carry_1(0), cout => carry_1(1), sum => xy_out2(0));
	row_1_2 : block_2 port map (b => x(2), c => y(1), a => xy_out1(2), cin => carry_1(1), cout => carry_1(2), sum => xy_out2(1));
	row_1_3 : block_3 port map (b => x(3), c => y(1), a => carry_1(2), cout => carry_1(3), sum => xy_out2(2));
	
	row_2_0 : block_3 port map (b => x(0), c => y(2), a => xy_out2(0), cout => carry_2(0), sum => zz(2));
	row_2_1 : block_2 port map (b => x(1), c => y(2), a => xy_out2(1), cin => carry_2(0), cout => carry_2(1), sum => xy_out3(0));
	row_2_2 : block_2 port map (b => x(2), c => y(2), a => xy_out2(2), cin => carry_2(1), cout => carry_2(2), sum => xy_out3(1));
	row_2_3 : block_2 port map (b => x(3), c => y(2), a => carry_1(3), cin => carry_2(2), cout => carry_2(3), sum => xy_out3(2));
	
	row_3_0 : block_3 port map (b => x(0), c => y(3), a => xy_out3(0), cout => carry_3(0), sum => zz(3));
	row_3_1 : block_2 port map (b => x(1), c => y(3), a => xy_out3(1), cin => carry_3(0), cout => carry_3(1), sum => zz(4));
	row_3_2 : block_2 port map (b => x(2), c => y(3), a => xy_out3(2), cin => carry_3(1), cout => carry_3(2), sum => zz(5));
	row_3_3 : block_2 port map (b => x(3), c => y(3), a => carry_2(3), cin => carry_3(2), cout => zz(7), sum => zz(6));
	
	z(0) <= zz(0);
	z(1) <= zz(1);
	z(2) <= zz(2);
	z(3) <= zz(3);
	z(4) <= zz(4);
	z(5) <= zz(5);
	z(6) <= zz(6);
	z(7) <= zz(7);
end rtl;

