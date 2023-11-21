import { memo, SVGProps } from 'react';

const Line1Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 2 238' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path d='M1.35352 0L0.757151 237.623' stroke='white' />
  </svg>
);

const Memo = memo(Line1Icon);
export { Memo as Line1Icon };
