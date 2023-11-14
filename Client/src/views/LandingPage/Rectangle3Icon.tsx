import { memo, SVGProps } from 'react';

const Rectangle3Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 306 213' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path d='M0 0H306V213H0V0Z' fill='white' />
  </svg>
);

const Memo = memo(Rectangle3Icon);
export { Memo as Rectangle3Icon };
