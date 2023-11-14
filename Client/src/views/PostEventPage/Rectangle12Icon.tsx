import { memo, SVGProps } from 'react';

const Rectangle12Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 1646 215' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path
      d='M0.0120869 10C0.0120869 4.47716 4.48924 0 10.0121 0H1636C1641.52 0 1646 4.47715 1646 10V204.276C1646 209.799 1641.52 214.276 1636 214.276H10.0121C4.48924 214.276 0.0120869 209.799 0.0120869 204.276V10Z'
      fill='#BB66FF'
    />
  </svg>
);

const Memo = memo(Rectangle12Icon);
export { Memo as Rectangle12Icon };
