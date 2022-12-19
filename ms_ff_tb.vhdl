library ieee;
use ieee.std_logic_1164.all;

entity ms_ff_tb is
end ms_ff_tb;

architecture testbench of ms_ff_tb is

    component ms_ff
	   port(
	       d,clk : in std_logic;
		   Q,not_Q : out std_logic
	   );
    end component;
	
	signal d,clk,Q,not_Q : std_logic;
begin
   
   ms_ff_map : ms_ff port map (d => d, clk => clk, Q => Q, not_Q => not_Q);
   
   process begin
     clk <= '0';
        d <= '0';
        wait for 10 ns;
        clk <= '1';
        d <= '0';
        wait for 10 ns;
        clk <= '0';
        d <= '1';
        wait for 10 ns;
        clk <= '1';
        d <= '1';
        wait for 10 ns;
		
		clk <= '0';
        d <= '0';
        wait for 10 ns;
        clk <= '0';
        d <= '1';
		wait for 10 ns;
		clk <= '1';
        d <= '0';
        wait for 10 ns;
        clk <= '1';
        d <= '1';
		wait for 10 ns;
		clk <= '0';
        d <= '0';
        wait for 10 ns;
        clk <= '0';
        d <= '1';
        wait;
    end process;
   
   
end testbench;