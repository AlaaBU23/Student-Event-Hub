import { memo, SVGProps } from 'react';

const Rectangle12Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 1693 272' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path
      d='M0.715601 9.99999C0.715601 4.47715 5.19275 0 10.7156 0H1683C1688.52 0 1693 4.47715 1693 10V261.655C1693 267.178 1688.52 271.655 1683 271.655H10.7156C5.19271 271.655 0.715601 267.178 0.715601 261.655V9.99999Z'
      fill='#BB66FF'
    />
  </svg>
);

const Memo = memo(Rectangle12Icon);
export { Memo as Rectangle12Icon };
