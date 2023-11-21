import { memo, SVGProps } from 'react';

const Rectangle5Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 306 227' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path d='M0 0H306V227H0V0Z' fill='#BB66FF' />
  </svg>
);

const Memo = memo(Rectangle5Icon);
export { Memo as Rectangle5Icon };
