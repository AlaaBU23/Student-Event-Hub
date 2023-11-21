import { memo, SVGProps } from 'react';

const Rectangle18Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 798 50' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path
      d='M0 5C0 2.23858 2.23858 0 5 0H793C795.761 0 798 2.23858 798 5V45C798 47.7614 795.761 50 793 50H4.99998C2.23856 50 0 47.7614 0 45V5Z'
      fill='white'
      stroke='black'
    />
  </svg>
);

const Memo = memo(Rectangle18Icon);
export { Memo as Rectangle18Icon };
