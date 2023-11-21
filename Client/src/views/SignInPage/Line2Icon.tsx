import { memo, SVGProps } from 'react';

const Line2Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 8 258' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path d='M3.62566 0.854391L4.39649 257.707' stroke='white' />
  </svg>
);

const Memo = memo(Line2Icon);
export { Memo as Line2Icon };
